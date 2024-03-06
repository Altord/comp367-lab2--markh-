pipeline {
    agent any

    tools {
        maven 'lab2'
    }

    stages {
        stage('Build') {
            options {
                timeout(time: 2, unit: 'MINUTES')
            }
            steps {
                bat 'mvn clean package'
            }
        }
    }
}
