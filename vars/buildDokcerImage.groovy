#!/usr/bin/env groovy

def call {
                       echo 'Building the Docker Image...'
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'docker build -t zulqarnain118/my-private-repo:1.3 .' 
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push zulqarnain118/my-private-repo:1.3' 

                }
}