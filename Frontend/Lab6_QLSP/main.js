// Khai bao danh sach cac san pham su dung trong chuong trinh
var dataDropdownlist = {
  Dell: ["7710", "5510", "XPS"],
  Apple: ["Iphone", "Ipad", "Air-pot"],
  SamSung: ["Galaxy Tab", "Note 10", "Galaxy Edge"],
};
// Do cac san pham vao dropdown list manufacturer

var Manufacturer_id = document.getElementById("Manufacturer_id");
var Manufacturer_Select_id = document.getElementById("Manufacturer_Select_id");
for (item in dataDropdownlist) {
  Manufacturer_Select_id.innerHTML += `<option value= "${item}">${item}></option>`;
}

//do cac san pham vao DropdownList categoryName
function showListManufacture() {
  var valueOfManufacture = Manufacturer_Select_id.value;
  var Category_Name_Select_ID = document.getElementById(
    "Category_Name_Select_ID"
  );
  Category_Name_Select_ID.innerHTML =
    '<option value="">--Pls Select--</option>';
  if (valueOfManufacture != "") {
    var valueOfManufacture_list = dataDropdownlist[valueOfManufacture];
    for (var i = 0; i < valueOfManufacture_list.length; i++) {
      Category_Name_Select_ID.innerHTML += `<option value = "${valueOfManufacture_list[i]}">${valueOfManufacture_list[i]}></option>`;
    }
  }
}

// Ham tinh gia tri cho hop Total_price
function updateTotalPrice() {
  var v_priceByID = document.getElementById("Price_id").value;
  var v_QuantityByID = document.getElementById("Quantity_id").value;
  var v_Total_PriceByID = v_priceByID * v_QuantityByID;
  document.getElementById("Total_Price_id").value = v_Total_PriceByID;
}

// Ham khi nhan nut Reset
function resetForm() {
  var v_product_Name_id = document.getElementById("Product_Name_id");
  var v_priceByID = document.getElementById("Price_id");
  var v_QuantityByID = document.getElementById("Quantity_id");
  var v_Total_PriceByID = document.getElementById("Total_Price_id");
  v_product_Name_id.value = "";
  v_priceByID.value = "";
  v_QuantityByID.value = "";
  v_Total_PriceByID.value = "";
}
var productList = [];
// Ham de them moi san pham
function addProduct() {
  var v_product_Name_id = document.getElementById("Product_Name_id");
  var v_Manufacturer_Select_id = document.getElementById(
    "Manufacturer_Select_id"
  );
  var v_Category_Name_Select_ID = document.getElementById(
    "Category_Name_Select_ID"
  );
  var v_priceByID = document.getElementById("Price_id");
  var v_QuantityByID = document.getElementById("Quantity_id");
  var v_Total_PriceByID = document.getElementById("Total_Price_id");

  var product = {
    product_name: v_product_Name_id.value,
    Manufacturer: v_Manufacturer_Select_id.value,
    Category_Name: v_Category_Name_Select_ID.value,
    price: v_priceByID.value,
    Quantity: v_QuantityByID.value,
    Total_Price: v_Total_PriceByID.value,
  };

  productList.push(product);
  showProduct();
  resetForm();
}

function showProduct() {
  var v_tb_product = document.getElementById("tb_product");
  v_tb_product.innerHTML = `<tr>
                    <th>No</th>
                    <th>Product Name</th>
                    <th>Manufacturer Name</th>
                    <th>Category Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
     </tr>`;
  for (var i = 0; i < productList.length; i++) {
    item = productList[i];
    v_tb_product.innerHTML += `<tr>
        <td>${i + 1}</td>
        <td>${item.product_name} Name</td>
        <td>${item.Manufacturer} Name</td>
        <td>${item.Category_Name}</td>
        <td>${item.price}</td>
        <td>${item.Quantity}</td>
        <td>
            <input type="button" value="Edit" class="btn btn-info" onclick="editProduct(${i})">
            <input type="button" value="Delete" class="btn btn-info" onclick="delProduct(${i})">
        </td> 
     </tr>`;
  }
}
// Ham sua thong tin san pham trong gio hang
function editProduct(index) {
  document.getElementById("Product_Name_id").value =
    productList[index].product_name;
  document.getElementById("Manufacturer_Select_id").value =
    productList[index].Manufacturer;
  document.getElementById("Category_Name_Select_ID").value =
    productList[index].Category_Name;
  document.getElementById("Price_id").value = productList[index].price;
  document.getElementById("Quantity_id").value = productList[index].Quantity;
  document.getElementById("Total_Price_id").value =
    productList[index].Total_Price;

  document.getElementById(
    "btn_id"
  ).innerHTML = `<input type="button" class="btn btn-info" value="Add Product" onclick="addProduct()">
              <input type="button" class="btn btn-info" value="Reset" onclick="resetForm()">`;
  document.getElementById(
    "btn_id"
  ).innerHTM += `<input type="button" value="Save" class="btn btn-info" onclick="saveProduct(${index})">`;
}

//Ham xu ly khi nhan nut Save de luu thay doi san pham

function saveProduct(index) {
  var v_product_Name_id = document.getElementById("Product_Name_id");
  var v_Manufacturer_Select_id = document.getElementById(
    "Manufacturer_Select_id"
  );
  var v_Category_Name_Select_ID = document.getElementById(
    "Category_Name_Select_ID"
  );
  var v_priceByID = document.getElementById("Price_id");
  var v_QuantityByID = document.getElementById("Quantity_id");
  var v_Total_PriceByID = document.getElementById("Total_Price_id");
  productList[index].product_Name = v_product_Name_id.value;
  productList[index].Manufacturer = v_Manufacturer_Select_id.value;
  productList[index].Category_Name = v_Category_Name_Select_ID.value;
  productList[index].price = v_priceByID.value;
  productList[index].Quantity = v_QuantityByID.value;
  productList[index].Total_Price = v_Total_PriceByID.value;
  showProduct();
}

// Xoa san pham
function delProduct(index) {
  productList.splice(index, 1);
  showProduct();
}
