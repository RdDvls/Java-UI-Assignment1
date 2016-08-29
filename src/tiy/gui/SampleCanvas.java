package tiy.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SampleCanvas extends Application {

    final double DEFAULT_SCENE_HEIGHT = 600;
    final double DEFAULT_SCENE_WIDTH = 800;

    public void setStrokeSize(double strokeSize) {
        this.strokeSize = strokeSize;
    }

    double strokeSize = 2;

    @Override
    public void start(Stage primaryStage) {
        Group rootGroup = new Group();

//        Scene mainScene = new Scene(rootGroup, 800, 600, Color.BLACK);


        Canvas canvas = new Canvas(DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        canvas.setFocusTraversable(true);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
        graphicsContext.setLineWidth(2);
//        drawShapes(graphicsContext);


        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("key pressed was: " + event.getCode().getName());
                if(event.getCode().getName() == "A"){
                    graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                }else if (event.getCode().getName() == "C"){
                    graphicsContext.clearRect(0,0,DEFAULT_SCENE_WIDTH,DEFAULT_SCENE_HEIGHT);
                }else if (event.getCode().getName() == "Up" && strokeSize <= 20){
                    strokeSize = strokeSize + 1;
                }else if (event.getCode().getName() == "Down" && strokeSize >= 2){
                    strokeSize = strokeSize - 1;
                }

            }
        });
        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {     //determines the user draws


            @Override
            public void handle(MouseEvent e) {    // something in common with this method and setOnKeyPressed method to change color when button pressed
//                e.getClickCount();
                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                graphicsContext.strokeText("Press A to change color",25,25, DEFAULT_SCENE_WIDTH);
                graphicsContext.strokeText("Press up arrow to increase circle size" , 75,75, DEFAULT_SCENE_WIDTH);
                graphicsContext.strokeText("Press down arrow to decrease circle size", 125,125,DEFAULT_SCENE_WIDTH);
                graphicsContext.strokeOval(e.getX(), e.getY(), strokeSize,strokeSize );
//                graphicsContext.strokeText("This is the text", e.getX(), e.getY());

            }
        });

        rootGroup.getChildren().add(canvas);
        Scene scene = new Scene(rootGroup, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
//    private void drawShapes(GraphicsContext gc) {
//        gc.setFill(Color.RED);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);
//        gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                new double[]{210, 210, 240, 240}, 4);
//    }
}

