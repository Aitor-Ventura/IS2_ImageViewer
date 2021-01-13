package control;

import model.Image;
import view.ImageDisplay;
import java.util.List;

public class NextImageCommand implements Command {
    
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public NextImageCommand(List<Image> imageList, ImageDisplay imageDisplay) {
        this.images = imageList;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.display(next());
    }
    
    private Image next () {
        return images.get(nextIndex());
    }

    private int nextIndex() {
        return (currentIndex()+1)%images.size();
    }

    private int currentIndex() {
        return images.indexOf(imageDisplay.current());
    }
}