
rd /s /q .\src\main\webapp\ext\

call mvn dependency:unpack-dependencies -DincludeArtifactIds=ext -DincludeGroupIds=com.sencha -DoutputDirectory=./src/main/webapp/ext/ -Dexcludes=**/META-INF/** -DoverWriteReleases=true
