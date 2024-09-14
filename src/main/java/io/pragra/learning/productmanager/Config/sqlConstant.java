package io.pragra.learning.productmanager.Config;

public class sqlConstant {

    public static final String CREATE_PRODUCT_SQL = "INSERT INTO PRODUCT VALUES (?, ?, ?,?)";

    public static final String UPDATE_PRODUCT_NAME_SQL = "UPDATE PRODUCT SET NAME = ? WHERE ID = ?";

    public static final String UPDATE_PRODUCT_DESC_SQL = "UPDATE PRODUCT SET DESCRIPTION = ? WHERE ID = ?";

    public static final String READ_PRODUCT_SQL = "SELECT * FROM PRODUCT ";

    public static final String READ_PRODUCT_BY_ID_SQL = "SELECT * FROM PRODUCT WHERE ID = ?";

    public static final String GET_PRODUCT_SEQ = "SELECT NEXT VALUE FOR product_id_seq";

}
