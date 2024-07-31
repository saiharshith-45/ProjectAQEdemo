pipeline {
    agent any

    environment {
        DOCKER_HUB_REPO = 'harshithsai45/mywebapp'
        DOCKER_HUB_CREDENTIALS_ID = 'docker-hub-credentials' // Jenkins credentials ID for Docker Hub
    }

    stages {
        stage('Clone Repository') {
            steps {
                 git branch: 'main', url: 'https://github.com/saiharshith-45/ProjectAQEdemo.git', credentialsId: 'git-hub-credentials'
            }
        }
        stage('Build with Maven') {
            steps {
                script {
                    def mvnHome = tool name: 'M3', type: 'maven'
                    withEnv(["MVN_HOME=$mvnHome"]) {
                        sh '"$MVN_HOME/bin/mvn" clean package'
                    }
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKER_IMAGE}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', "${DOCKER_HUB_CREDENTIALS}") {
                        docker.image("${env.DOCKER_IMAGE}").push('latest')
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline succeeded.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
