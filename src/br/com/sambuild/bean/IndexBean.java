package br.com.sambuild.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@Named
@RequestScoped
public class IndexBean implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -1456964429219795350L;

    private DashboardModel model;

    public IndexBean() {
	model = new DefaultDashboardModel();
	DashboardColumn column1 = new DefaultDashboardColumn();
	DashboardColumn column2 = new DefaultDashboardColumn();
	DashboardColumn column3 = new DefaultDashboardColumn();
	DashboardColumn column4 = new DefaultDashboardColumn();
	DashboardColumn column5 = new DefaultDashboardColumn();
	DashboardColumn column6 = new DefaultDashboardColumn();
	DashboardColumn column7 = new DefaultDashboardColumn();
	DashboardColumn column8 = new DefaultDashboardColumn();

	column1.addWidget("produtos");
	column5.addWidget("vendas");

	column2.addWidget("fornecedores");
	column6.addWidget("clientes");

	column3.addWidget("contasMovimentacoes");
	column7.addWidget("relatorios");

	column4.addWidget("sistema");

	model.addColumn(column1);
	model.addColumn(column2);
	model.addColumn(column3);
	model.addColumn(column4);
	model.addColumn(column5);
	model.addColumn(column6);
	model.addColumn(column7);
	model.addColumn(column8);
    }

    public DashboardModel getModel() {
	return model;
    }
}
