package de.articdive.commentedconfiguration.config.file;

import de.articdive.commentedconfiguration.interfaces.ConfigurationSection;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.representer.Representer;

public class YamlRepresenter extends Representer {

	public YamlRepresenter() {
		this.multiRepresenters.put(ConfigurationSection.class, new RepresentConfigurationSection());
	}

	private class RepresentConfigurationSection extends RepresentMap {
		@Override
		public Node representData(Object data) {
			return super.representData(((ConfigurationSection) data).getValues(false));
		}
	}
}