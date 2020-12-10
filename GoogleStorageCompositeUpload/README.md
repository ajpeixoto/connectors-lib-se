Module created to test the parallel composite upload feature of Google Cloud Storage

        GoogleCredentials credentials = null;
        File credentialsPath = new File("myCred.json"); 
        try (FileInputStream serviceAccountStream = new FileInputStream(credentialsPath)) {
          credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        
        String fileToUpload = "bigFileToUpload.bin";
        
        StorageCompositeParallelUploader uploader = 
            new StorageCompositeParallelUploader.Builder(storage, "tdi_rlecomte", fileToUpload, "bigFile.bin")
                .withInitialThreadCount(1)
                .withMaxThreadCount(1)
                .withChunkSize(100 * 1024 * 1024)
                .withAwaitTerminationValue(2)
                .withAwaitTerminationUnit(TimeUnit.HOURS)
                .withBufferSize(100 * 1024 * 1024)
                .build();
       
        uploader.upload();
        