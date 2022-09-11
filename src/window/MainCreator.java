package window;

import util.Output;
import util.ScannerReader;
import window.view.MainMenuView;
import window.view.ViewBox;

public class MainCreator implements ViewBox {
    private final String appDetails;
    private final ScannerReader scanner;
    private final Output output;

    private final StringBuilder fieldBuilder;

    public MainCreator(String appDetails, ScannerReader scanner, Output output) {
        this.appDetails = appDetails;
        this.scanner = scanner;
        this.output = output;
        this.fieldBuilder = new StringBuilder();
    }

    public void showView() {
        output.clear();
        output.println(appDetails);
        String blockUp = Character.toString(HEADER_SIGN).repeat(WIDTH);
        String indent = Character.toString(SIDE_SIGN).repeat(SIDE_WIDTH);

        System.out.println(blockUp);
        for (MainMenuView value : MainMenuView.values()) {
            output.println(fieldBuilder.append(indent).append(" ").append(value).toString());
            fieldBuilder.setLength(0);
        }
        System.out.println(blockUp);
    }
}
