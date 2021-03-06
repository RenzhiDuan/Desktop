package org.docear.plugin.services.features.documentretrieval.recommendations.workspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.docear.plugin.services.features.documentretrieval.recommendations.actions.ShowRecommendationsAction;
import org.freeplane.core.util.TextUtils;
import org.freeplane.plugin.workspace.components.menu.WorkspacePopupMenu;
import org.freeplane.plugin.workspace.components.menu.WorkspacePopupMenuBuilder;
import org.freeplane.plugin.workspace.model.AWorkspaceTreeNode;
import org.freeplane.plugin.workspace.nodes.AActionNode;

public class ShowRecommendationsNode extends AActionNode {

	//private static final Icon DEFAULT_ICON = new ImageIcon(ShowRecommendationsNode.class.getResource("/icons/books.png"));
	private static final Icon DEFAULT_ICON = new ImageIcon(ShowRecommendationsNode.class.getResource("/icons/star.png"));

	private static final long serialVersionUID = 1L;
	
	private WorkspacePopupMenu popupMenu = null;
	
	
	public ShowRecommendationsNode() {
		super(ShowRecommendationsAction.TYPE);
		setName(TextUtils.getText("recommendations.workspace.node"));
	}

	@Override
	public void initializePopup() {
		if (popupMenu == null) {						
			popupMenu  = new WorkspacePopupMenu();
			WorkspacePopupMenuBuilder.addActions(popupMenu, new String[] {					
					"RecommendationsRefreshAction"
			});
		}
		
	}

	@Override
	public WorkspacePopupMenu getContextMenu() {
		if (popupMenu == null) {
			initializePopup();
		}
		return popupMenu;
	}
	
	public boolean setIcons(DefaultTreeCellRenderer renderer) {
		renderer.setOpenIcon(DEFAULT_ICON);
		renderer.setClosedIcon(DEFAULT_ICON);
		renderer.setLeafIcon(DEFAULT_ICON);
		return true;
	}
	
	public void refresh() {		
		//ServiceController.getController().getRecommenationMode().getMapController().refreshRecommendations();
	}
	
	protected AWorkspaceTreeNode clone(ShowRecommendationsNode node) {
		return super.clone(node);
	}
	
	public final String getTagName() {
		return null;
	}

	@Override
	public AWorkspaceTreeNode clone() {
		ShowRecommendationsNode node = new ShowRecommendationsNode();
		return clone(node);
	}
}
