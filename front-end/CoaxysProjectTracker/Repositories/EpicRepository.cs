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
            List<Epic> items = await Api.GetAsync<List<Epic>>("epic.json");
            return items;
        }

        public async Task<Epic> GetEpicByID(int id)
        {
            Epic item = await Api.GetAsync<Epic>("epic1.json");
            return item;
        }

        public async Task<Epic> InsertEpic(Epic epic)
        {
            Epic newItem = await Api.GetAsync<Epic>("epic1.json");
            return newItem;
        }

        public async Task<Epic> UpdateEpic(Epic epic)
        {
            Epic updatedItem = await Api.GetAsync<Epic>("epic1.json");
            return updatedItem;
        }

        public async Task<Epic> DeleteEpic(Epic epic)
        {
            Epic deletedItem = await Api.GetAsync<Epic>("epic1.json");
            return deletedItem;
        }
    }
}
