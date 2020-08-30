pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-11'
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
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}