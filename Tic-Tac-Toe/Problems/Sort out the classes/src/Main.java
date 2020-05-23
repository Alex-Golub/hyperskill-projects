

public static void sortShapes(Shape[] array,
                              List<Shape> shapes,
                              List<Polygon> polygons,
                              List<Square> squares,
                              List<Circle> circles) {
  // shape => Polygon => Square
  // shape => Circle
        for (Shape shape : array) {
          String name = shape.getClass().getSimpleName();
          switch(name) {
            case "Polygon": polygons.add((Polygon)shape); break;
            case "Square": squares.add((Square)shape); break;
            case "Circle": circles.add((Circle)shape); break;
            default: shapes.add(shape); break;
        }
        }
}