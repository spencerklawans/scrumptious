import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.ui.ContactForm;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the main-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-view")
@JsModule("./src/views/main-view.js")
public class MainView extends PolymerTemplate<MainView.MainViewModel> {

    @Id("contactForm")
	private ContactForm contactForm;

	/**
     * Creates a new MainView.
     */
    public MainView() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between MainView and main-view
     */
    public interface MainViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
