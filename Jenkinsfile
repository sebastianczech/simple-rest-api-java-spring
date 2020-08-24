pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-11'
            args '-v /var/jenkins_home/.m2:/var/jenkins_home/.m2'
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
        stage('Test') {
            steps {
                echo 'Unit testing..'

                sh 'mvn test'
            }
        }
    }
}