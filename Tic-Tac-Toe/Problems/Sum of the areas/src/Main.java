
  public static int sumOfAreas(Shape[] array) {
    int totalArea = 0;
    for (Shape shape : array) {
      if (Rectangle.class.isInstance(shape)) {
        totalArea += ((Rectangle)shape).getHeight() * ((Rectangle)shape).getWidth();
      } else if (Square.class.isInstance(shape)) {
        totalArea += ((Square)shape).getSide() * ((Square)shape).getSide();
      }
    }
    return totalArea;
  }
