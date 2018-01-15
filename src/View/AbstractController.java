package View;

import Main.ViewModel;

public class AbstractController {
    protected ViewModel viewModel;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
