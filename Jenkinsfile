pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Info') {
            steps {
                echo 'Current working directory: '

                sh 'pwd'

                echo 'List of files: '

                sh 'ls -la'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'

                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test unit') {
            steps {
                echo 'Unit testing..'

                sh 'mvn test'
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