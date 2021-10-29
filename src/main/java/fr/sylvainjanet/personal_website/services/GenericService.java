package fr.sylvainjanet.personal_website.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.sylvainjanet.personal_website.dto.tools.DtoTools;
import fr.sylvainjanet.personal_website.entities.MyEntity;
import fr.sylvainjanet.personal_website.repositories.IGenericRepository;

public abstract class GenericService<T extends MyEntity, TDto> implements IGenericService<TDto> {

	protected IGenericRepository<T> tRepository;

	private Class<TDto> clazzTDto;

	@Autowired
	public GenericService(Class<TDto> clazzTDto, IGenericRepository<T> tRepository) {
		this.clazzTDto = clazzTDto;
		this.tRepository = tRepository;
	}

	@Override
	public List<TDto> getAll() {
		List<T> lst = tRepository.findAll();
		List<TDto> result = new ArrayList<TDto>();
		for (T t : lst) {
			result.add(DtoTools.convert(t, clazzTDto));
		}
		return result;
	}
}
