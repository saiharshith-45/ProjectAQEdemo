pipeline {
    agent any
    tools {
        maven 'M3' // Ensure this matches the name configured in Jenkins
        git 'Default' // Ensure this matches the name configured in Jenkins
    }
    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials')
    }
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/saiharshith-45/ProjectAQEdemo.git'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('harshithsai45/mywebapp:latest')
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_HUB_CREDENTIALS) {
                        docker.image('harshithsai45/mywebapp:latest').push()
                    }
                }
            }
        }
    }
}
