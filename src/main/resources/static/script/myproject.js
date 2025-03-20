function openModal() {
    document.getElementById("projectModal").style.display = "flex";
}

function closeModal() {
    document.getElementById("projectModal").style.display = "none";
}


async function openModal(id = null) {
    document.getElementById("ProjectModal").style.display = "block";

    if(id){
        const response =await fetch(`/client/myproject/${id}`).catch((err)=>
            console.log(err)
        );
        const category = await response.json();
        console.log(project);
        setFields(project);
        
           
    }
}

function setFields(project){
    document.getElementById("projectId").value=project.projectId;
    document.getElementById("projectTitle").value=project.projectTitle;
    document.getElementById("projectDescription").value=project.projectDescription;
    document.getElementById("projectImages").value=project.projectImageUrl;
    document.getElementById("projectprice").value=project.projectprice;
    document.getElementById("projectStatus").value=project.projectStatus;
}

function closeModal() {
    document.getElementById("projectModal").style.display = "none";
}


