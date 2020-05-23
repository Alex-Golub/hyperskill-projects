static void performIterationsWithCallback(int numberOfIterations, LoopCallback callback) {
    for (int i = 0; i < numberOfIterations; i++) {
        callback.onNewIteration(i);
    }
}

static void startIterations(int numberOfIterations) {
    // invoke the method performIterationsWithCallback here
        LoopCallback callback = new LoopCallback() {
          @Override
          public void onNewIteration(int iteration) {
              System.out.println("Iteration: " + iteration);
          }
        };
        performIterationsWithCallback(numberOfIterations, callback);
}