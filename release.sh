# Exit if any operation fails
set -e

majorminor=1.0.0

#Agility-style
version=$majorminor.beta.$(date '+v%Y%m%d_%H%M')
echo Version is $version 

echo "Git status check..."
git status | grep "nothing to commit"
echo "Git is good"

echo "Setting artifact version..."
mvn versions:set -DnewVersion=$version -DgenerateBackupPoms=false

echo "Building..."
mvn clean install -P security-disabled,arc

echo "Deploying..."
cd dcm4chee-xds2-registry-ear
mvn deploy -P security-disabled,arc

echo "Committing, tagging, reverting ..." 
git add -A && git commit -m "Release $version"
git tag $version
git reset --hard HEAD@{1}

echo "We're done!"
