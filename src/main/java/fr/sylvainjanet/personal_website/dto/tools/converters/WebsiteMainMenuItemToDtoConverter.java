package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;

public class WebsiteMainMenuItemToDtoConverter extends AbstractConverter<List<WebsiteMainMenuItem>, List<Integer>> {

	@Override
	protected List<Integer> convert(List<WebsiteMainMenuItem> input) {

		return input.stream().map(wsmi -> (int) wsmi.getId()).collect(Collectors.toList());
	}
}
