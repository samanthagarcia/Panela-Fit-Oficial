package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import beans.MateriaPrima;

public class RepositorioMateriaPrima implements IRepositorioMateriaPrima{
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	private static RepositorioMateriaPrima instance;
	
	public RepositorioMateriaPrima(){
		this.listaMateriasPrimas = new ArrayList<MateriaPrima>();
	}
	
	public static RepositorioMateriaPrima getInstance(){
		if(instance == null){
			instance = new RepositorioMateriaPrima();
		}
		return instance;
	}
	
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}

	public void setListaMateriasPrimas(ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}

	public boolean cadastrarMateriaPrima(MateriaPrima materiaPrima) {
		try{
			listaMateriasPrimas.add(materiaPrima);
		}catch (Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima) {
		boolean alt = false;
	for(MateriaPrima materiaPrima : listaMateriasPrimas){	
		if(materiaPrima.getCodigo() == mpAlterada.getCodigo()){
			listaMateriasPrimas.remove(materiaPrima);
				listaMateriasPrimas.add(novaMateriaPrima);
					alt = true;
			}
		}
		return alt;
	}
	
	public MateriaPrima buscarMateriaPrima(int codigo) {
		for(MateriaPrima mp : listaMateriasPrimas) {
			if(mp.getCodigo() == codigo) {
				return mp;
			}
		}
		return null;
	}
	
	public boolean removerMateriaPrima(int codigo) {
		boolean igual = false;
		for(int i=0;i<listaMateriasPrimas.size();i++){
			if(listaMateriasPrimas.get(i).getCodigo() == codigo){
				listaMateriasPrimas.remove(i);
					igual = true;
		}
	}
	return igual;
	}
	
	public boolean materiaPrimaExiste(int codigo) {
		int m;
		boolean x = false;
		for(MateriaPrima mp : listaMateriasPrimas) {
			m = mp.getCodigo();
			if(m == codigo) {
				x = true;
			}
		}
		return x;
	}
	
	public List<MateriaPrima> listar(){
		return Collections.unmodifiableList(this.listaMateriasPrimas);
	}
	
	@Override
	public String toString() {
		return "RepositorioMateriaPrima [listaMateriasPrimas = " + listaMateriasPrimas + "]";
			
	}
}