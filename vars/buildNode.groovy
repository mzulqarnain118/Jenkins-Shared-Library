#!/usr/bin/env groovy

def call {
               echo "Building the application... for branch $BRANCH_NAME"
                // Jenkins will use the globally installed Node.js and npm
                sh 'npm install'
}