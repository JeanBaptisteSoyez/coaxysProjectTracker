using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Models;

namespace CoaxysProjectTracker.Repositories
{
    public class EpicRepository
    {
        public async Task<List<Epic>> GetEpics()
        {
            List<Epic> epics = await Api.GetAsync<List<Epic>>("epic.json");
            return epics;
        }

        public async Task<Epic> GetEpicByID(int id)
        {
            Epic epic = await Api.GetAsync<Epic>("epic1.json");
            return epic;
        }

        public void InsertEpic()
        {

        }

        public void UpdateEpic()
        {

        }

        public void DeleteEpic()
        {

        }
    }
}
