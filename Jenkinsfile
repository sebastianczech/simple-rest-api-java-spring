pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.0.27:8083"
        NEXUS_REPOSITORY = "maven-nexus-repo"
        NEXUS_CREDENTIAL_ID = "nexus"
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
        stage('Test acceptance') {
            steps {
                echo 'Acceptance testing..'
            }
        }
        stage('Publish to Nexus') {
            steps {
                script {
                    // required plugins: pipeline-utility-steps, nexus-artifact-uploader
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }
        stage('Publish to artifactory') {
            steps {
                rtUpload (
                    serverId: 'artifactory_homelab',
                    spec: '''{
                          "files": [
                            {
                              "pattern": "target/api*.jar",
                              "target": "libs-release-local"
                            }
                         ]
                    }''',

                    // Optional - Associate the uploaded files with the following custom build name and build number,
                    // as build artifacts.
                    // If not set, the files will be associated with the default build name and build number (i.e the
                    // the Jenkins job name and number).
                    buildName: 'holyFrog',
                    buildNumber: '42'
                )
            }
        }
    }
}