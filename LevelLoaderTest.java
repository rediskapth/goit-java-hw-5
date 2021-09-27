class Level {
    private int width;
    private int height;
  private int square;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }
  public Level (int square){
    this.square = square;
  }
  
  public int getSquare(){
    return width*height;
  }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
        if ( level.getSquare() > 100000) {
            throw new LevelTooBigException();
        }
        System.out.println("Level loaded");
    }
}

class LevelTooBigException extends Exception {
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}