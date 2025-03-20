async function openModal(id = null) {
    document.getElementById("categoryModal").style.display = "block";

    if(id){
        const response =await fetch(`/admin/category/${id}`).catch((err)=>
            console.log(err)
        );
        const category = await response.json();
        console.log(category);
        setFields(category);
        
           
    }
}

function setFields(category){
    document.getElementById("categoryId").value=category.categoryId;
    document.getElementById("categoryImages").value=category.categoryImageUrl;
    document.getElementById("categoryName").value=category.categoryName;
    document.getElementById("categoryDescription").value=category.categoryDescription;
    document.getElementById("categoryStatus").value=category.categoryStatus;
}

function closeModal() {
    document.getElementById("categoryModal").style.display = "none";
}
