package org.cejug.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import org.cejug.persistence.util.Identified;

/**
 * Classe Entity Fabricante.
 *
 * @author Helio Frota, Hildeberto Mendonca
 *
 */
@Entity
@Table(name = "fabricante")
public class Fabricante implements Serializable, Identified {

    private static final long serialVersionUID = -3466398603052152979L;
    
    @Id
    private String id;

    private String nome;

    @Enumerated(EnumType.ORDINAL)
    private FabricanteTipo tipo;

    public Fabricante() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FabricanteTipo getTipo() {
        return tipo;
    }

    public void setTipo(FabricanteTipo tipo) {
        this.tipo = tipo;
    }

    public String getTipoLiteral() {
        switch(this.tipo) {
            case HARDWARE:
                return "Hardware";
            case SOFTWARE:
                return "Software";
            default:
                return "Hardware/Software";
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fabricante other = (Fabricante) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + " nome: " + nome + " tipo: " + tipo;
    }
}