/*using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CoaxysProjectTracker.Api;

namespace CoaxysProjectTracker.Entities
{
    class ProjectRepository
    {
        private List<Project> projects;

        protected async Task<List<Project>> LoadProjects()
        {
            projects = await API.GetAsync<List<Project>>("project.json");
            return projects;
        }

        public IEnumerable<Project> GetProjects()
        {
            throw new NotImplementedException();
        }

        public Project GetProjectByID(int id)
        {
            throw new NotImplementedException();
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
}*/
