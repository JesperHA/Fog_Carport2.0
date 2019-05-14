package FacadeLayer;

import DBAccess.MaterialMapper;
import Model.Material;

import java.util.ArrayList;

public class MaterialFacade {

    private static ArrayList<Material> materials;

    public static ArrayList<Material> getMaterials(){

        materials = MaterialMapper.getMaterialList();

        return materials;

    }

}
