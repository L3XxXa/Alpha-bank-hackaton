Короче, для начала нужно забилдить JAR file.
Для этого в этой папке пишешь gradlew bootJar
После этого делаешь image: "docker build -t alpha ."
После этого пишешь docker-compose up -d
После этого все должно работать