package eu.indevgroup.cn1.test.transparent;


import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

public class main {

    private Form current;

    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form hi = new Form("Transparents");
        hi.getContentPane().setLayout(new GridLayout(3, 2));
        hi.getContentPane().setUIID("form");
        hi.getContentPane().setScrollableY(false);
        for (int i=0; i<6; i++) {
            Component c = new Component() {

                @Override
                protected Dimension calcPreferredSize() {
                    return new Dimension(
                            Display.getInstance().getDisplayWidth(), 
                            Display.getInstance().getDisplayHeight()
                    );
                }
                
            };
            c.setUIID("cmp"+i);
            hi.addComponent(c);
        }
        hi.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

}
