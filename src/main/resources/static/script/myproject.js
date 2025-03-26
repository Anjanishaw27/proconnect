async function openModal(id = null) {
    document.getElementById("projectModal").style.display = "block";

    if (id) {
        const response = await fetch(`/client/myprojectedit/${id}`).catch((err) =>
            console.log(err)
        );
        const project = await response.json();
        console.log(project);
        setFields(project);
    }
    return false;
}

function setFields(project) {
    document.getElementById("projectId").value = project.projectId;
    document.getElementById("projectImageName").value = project.projectImageUrl;
    document.getElementById("projectTitle").value = project.projectTitle;
    document.getElementById("projectDescription").value = project.projectDescription;
    document.getElementById("projectPrice").value = project.projectPrice;
    document.getElementById("category").value = project.category.categoryId;
}

function closeModal() {
    document.getElementById("projectModal").style.display = "none";
}


