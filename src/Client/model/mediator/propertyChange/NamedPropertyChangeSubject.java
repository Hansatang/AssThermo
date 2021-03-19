package Client.model.mediator.propertyChange;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject
{
  void addListener(String propertyName, PropertyChangeListener listener);
}
