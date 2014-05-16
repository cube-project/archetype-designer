 
package fr.liglab.adele.cube.archetype.designer.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import fr.liglab.adele.cube.archetype.designer.model.Element;
import fr.liglab.adele.cube.archetype.designer.model.ElementValue;
import fr.liglab.adele.cube.archetype.designer.model.IArchetypeService;

public class AddValueHandler {
	@Inject
	IArchetypeService arch;
	
	@Execute
	public void execute() {		
		Element e = new ElementValue(this.arch.getCurrentArchetype(), "VALUE");	
		if (this.arch.getCurrentArchetype() != null) {
			this.arch.getCurrentArchetype().setSelectedObject(e);
		}
	}
	
	@CanExecute
	public boolean canExecute() {		
		return this.arch != null && this.arch.getCurrentArchetype() != null 
				&& this.arch.getCurrentArchetype().isAddingGoal() == false
						&& this.arch.getCurrentArchetype().isAddingProperty() == false;
	}
		
}