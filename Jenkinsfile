pipeline {
    agent any

    tools {
        gradle 'gradle'
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building..'
                bat 'gradle clean build -x test'
            }
        }

        stage('Test') {
            steps {
                echo 'Tests are skipped for now'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
