pipeline {
    agent any

    environment {
        DOCKER_HUB_REPO = 'harshithsai45/mywebapp'
        DOCKER_HUB_CREDENTIALS_ID = 'docker-hub-credentials' // Jenkins credentials ID for Docker Hub
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/username/mywebapp.git'
            }
        }
        stage('Build with Maven') {
            steps {
                withMaven(maven: 'M3') {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def app = docker.build("${DOCKER_HUB_REPO}:latest", "-f Dockerfile .")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS_ID) {
                        app.push('latest')
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
 
