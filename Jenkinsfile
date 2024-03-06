pipeline {
    agent any

    tools {
        maven 'lab2'
    }

    stages {
        stage('Build') {
            steps {

                sh 'mvn clean package'
            }
        }
    }
}
