pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test unit') {
            steps {
                echo 'Unit testing..'
            }
        }
        stage('Test integration') {
            steps {
                echo 'Integration testing..'
            }
        }
        stage('Test e2e') {
            steps {
                echo 'E2E testing..'
            }
        }
        stage('Deploy test') {
            steps {
                echo 'Deploying to test environment....'
            }
        }
        stage('Deploy stage') {
            steps {
                echo 'Deploying to stage environment....'
            }
        }
        stage('Deploy prod') {
            steps {
                echo 'Deploying to production environment....'
            }
        }
    }
}