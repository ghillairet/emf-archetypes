package ${package};

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class View extends Composite {

	interface Binder extends UiBinder<Widget, View> {}
	private static Binder uiBinder = GWT.create(Binder.class);

	@UiField Label label;
	@UiField TextBox textBox;
	@UiField Button saveButton;

	public View() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
		textBox.setText(text);
	}

	public void handleClickSave(ClickHandler handler) {
		saveButton.addClickHandler(handler);
	}

}
