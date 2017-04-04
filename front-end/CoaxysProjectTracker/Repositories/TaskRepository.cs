using CoaxysProjectTracker.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;

namespace CoaxysProjectTracker.Repositories
{
    public class TaskRepository
    {

        public async Task<List<Task>> GetTasks()
        {
            List<Task> tasks = await Api.GetAsync<List<Task>>("task.json");

            return tasks;
        }

        public async Task<Task> GetTaskByID(int id)
        {
            Task task = await Api.GetAsync<Task>("taskX.json");

            return task;
        }

        public void CreateTask(string name, string param, string process, string result)
        {
            Models.Task task = new Models.Task() ;
            task.Name = name;
            task.Process = process;
            task.EntryParameter = param;
            task.Result = result;
            
        }

        public void DeleteTask(int id)
        {

        }

        public void EditTask(int id)
        {

        }


    }


}