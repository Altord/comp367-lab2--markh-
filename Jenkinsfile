pipeline {
    agent any
    
    tools {
        maven 'lab2'
    }

    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-creds'
        IMAGE_TAG = 'ymarkh/mywebapp:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build Maven Project') {
            steps {
                script {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${IMAGE_TAG} ."
                }
            }
        }

        stage('Docker Login') {
            steps {
               script {
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        bat "docker login --username %DOCKER_USERNAME% --password %DOCKER_PASSWORD%"
                    }
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    bat "docker push ${IMAGE_TAG}"
                }
            }
        }
    }
}
