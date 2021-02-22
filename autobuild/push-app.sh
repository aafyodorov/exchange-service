#!/bin/sh

git clone https://github.com/aafyodorov/exchange-service.git repo_autobuild
cd repo_autobuild || exit 1

mv /home/travis/build/aafyodorov/exchange-service/target/*.jar ./autobuild/

# Setup git for commit and push
git config --global user.email "travis@travis-ci.com"
git config --global user.name "Travis CI"
git remote set-url origin "https://aafyodorov:${GIT_HUB_ACCESS_TOKEN}@github.com/aafyodorov/exchange-service"
# /dev/null 2>&1

git rm --cached ./autobuild/*.jar
git add ./autobuild/*.jar

git commit --message "Snapshot autobuild No.$TRAVIS_BUILD_NUMBER [ci skip]"
git push origin master