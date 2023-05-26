package project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project.app.dao.AppItemRepository;
import project.app.model.Item;

@Service
@Transactional
public class AppService {

	@Autowired
	private AppItemRepository itemRepository;
	
	public List<Item>findItems(){
		return itemRepository.findAll();
	}
	public void saveItem(Item item) {
		itemRepository.create(item);
	}
	public void deleteItem(long id) {
		itemRepository.delete(id);
	}
	public Item getIteml(long id) {
		return itemRepository.findById(id);
	}
}
