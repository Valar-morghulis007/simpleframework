package demo.pattern.eventmode;

public class DoubleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if("doubleClick".equals(event.getType())){
            System.out.println("双击被触发了");
        }
    }
}
