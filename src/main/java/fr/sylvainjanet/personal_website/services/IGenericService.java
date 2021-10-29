package fr.sylvainjanet.personal_website.services;

import java.util.List;

public interface IGenericService<TDto> {

	List<TDto> getAll();

//	List<TDto> getAll(int page, int max);
//
//	TDto getById(Long id);
//
//	void deleteById(Long id);
//
//	TDto saveOrUpdate(TDto obj);
//
//	CountDto count();
//
//	boolean exists(Long id);
//
//	List<TDto> getAllOrderedBy(int page, int max, FieldSort... fieldSorts);
//
//	List<TDto> findByKeyword(int page, int max, KeywordGroup... keywordGroups);
//	
//	long countByKeyword(KeywordGroup... keywordGroups);
}
