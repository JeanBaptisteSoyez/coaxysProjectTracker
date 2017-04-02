using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CoaxysProjectTracker.Api;

namespace CoaxysProjectTracker.Entities
{
    public class ProjectRepository
    {
        public async Task<List<Project>> GetProjects()
        {
            List<Project> projects = await API.GetAsync<List<Project>>("project.json");
            return projects;
        }

        public async Task<Project> GetProjectByID(int id)
        {
            Project project = await API.GetAsync<Project>("project1.json");
            return project;
        }

        public void InsertProject()
        {

        }

        public void UpdateProject()
        {

        }

        public void DeleteProject()
        {

        }
    }
}
