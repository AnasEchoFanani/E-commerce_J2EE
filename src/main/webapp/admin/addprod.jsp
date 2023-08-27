<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Add Product</title>

    <!-- Icons font CSS-->
    <link href="admin/vendor_sign/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="admin/vendor_sign/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="admin/vendor_sign/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="admin/vendor_sign/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="admin/css_sign/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Add Products</h2>
                </div>


                <div class="card-body">
                    <form action="produit" method="post" enctype="multipart/form-data">
                        <div class="form-row m-b-55">
                            <div class="name">Name</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="nomProduit">
                                            <label class="label--desc">first name</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input name="action" value="add" hidden>
                        <div class="form-row m-b-55">
                         <div class="name">Quantity</div>
                         <div class="value">
                           <div class="row row-refine">
                         <div class="col-9">
                          <div class="input-group-desc">
                          <input class="input--style-5" type="number" name="qnt">
                          <label class="label--desc">product price</label>
                                      </div>
                                   </div>
                               </div>
                          </div>
                    </div>

<div class="form-row m-b-55">
<label for="category" class="name">Choose a category:</label>
<select name="idCategor" class="form-select" id="category">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select>
</div>


                        <div class="form-row m-b-55">
                            <div class="name">Price</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="number" name="prix">
                                            <label class="label--desc">product price</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="form-row m-b-55">
                                                    <div class="name">Img</div>
                                                    <div class="value">
                                                        <div class="row row-refine">
                                                            <div class="col-9">
                                                                <div class="input-group-desc">
                                                                    <input class="input--style-5" type="file" name="imageFile">
                                                                    <label class="label--desc">product image</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>





                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="admin/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="admin/vendor/select2/select2.min.js"></script>
    <script src="admin/vendor/datepicker/moment.min.js"></script>
    <script src="admin/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="admin/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
