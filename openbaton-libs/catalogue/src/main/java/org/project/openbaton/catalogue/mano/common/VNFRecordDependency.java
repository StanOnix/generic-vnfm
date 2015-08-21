package org.project.openbaton.catalogue.mano.common;

import org.project.openbaton.catalogue.nfvo.DependencyParameters;
import org.project.openbaton.catalogue.util.IdGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by lto on 08/06/15.
 */
@Entity
public class VNFRecordDependency implements Serializable {

    @Id
    private String id = IdGenerator.createUUID();
    @Version
    private int version = 0;

    @OneToMany(cascade = {CascadeType.REFRESH/*, CascadeType.MERGE*/}, fetch = FetchType.EAGER)
    private Set<VirtualNetworkFunctionRecord> sources;

    @OneToOne(cascade = {CascadeType.REFRESH/*, CascadeType.MERGE*/}, fetch = FetchType.EAGER)
    private VirtualNetworkFunctionRecord target;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, DependencyParameters> parameters;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> idType;

//    @Enumerated(EnumType.STRING)
//    private Status status;

    public VNFRecordDependency() {
    }

    public Map<String, String> getIdType() {
        return idType;
    }

    public void setIdType(Map<String, String> idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "VNFRecordDependency{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", target=" + target.getName() + " ( " + target.getId() + ")" +
                ", parameters=" + parameters +
                ", idType=" + idType +
                '}';
    }

    public Map<String, DependencyParameters> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, DependencyParameters> parameters) {
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public VirtualNetworkFunctionRecord getTarget() {
        return target;
    }

    public void setTarget(VirtualNetworkFunctionRecord target) {
        this.target = target;
    }

//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
}
